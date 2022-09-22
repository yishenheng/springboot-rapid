import co.elastic.clients.elasticsearch.ElasticsearchAsyncClient;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.bulk.BulkResponseItem;
import com.alibaba.fastjson.JSON;
import com.yishenheng.rapid.data.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author yishenheng
 * @date 2022/9/21 11:11
 */
@Service
public class CreateElasticsearchTest extends BaseTest {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Autowired
    private ElasticsearchAsyncClient elasticsearchAsyncClient;

    private static final String INDEX_NAME = "products";

    /**
     * 使用流畅的 DSL编辑
     *
     * @throws IOException io
     */
    @Test
    public void dslCreateIndex() throws IOException {
        Product createProduct = new Product("iPhone14 Pro", UUID.randomUUID().toString(), new BigDecimal("7999"), "这是一台手机");


        // 构建请求最直接的方法是使用 fluent DSL。在下面的示例中，我们在索引中索引产品描述products，使用产品的 SKU 作为索引中的文档标识符。
        // 该product对象将使用 Elasticsearch 客户端上配置的对象映射器映射到 JSON。(官网翻译)
        IndexResponse products = this.elasticsearchClient.index(i -> i
                .index(INDEX_NAME)
                .id(createProduct.getSkuId())
                .document(createProduct));


        // 您还可以将使用 DSL 创建的对象分配给变量。Java API 客户端类of()对此有一个静态方法，它使用 DSL 语法创建一个对象。(官网翻译)
        IndexRequest<Product> request = IndexRequest.of(i -> i
                .index("products")
                .id(createProduct.getSkuId())
                .document(createProduct)
        );
        IndexResponse response = elasticsearchClient.index(request);

        System.out.println(products.version());
        System.out.println(response.version());

    }


    /**
     * 使用经典构造器
     *
     * @throws IOException io
     */
    @Test
    public void classicCreateIndex() throws IOException {
        Product createProduct = new Product("iPhone14 Pro Max", UUID.randomUUID().toString(), new BigDecimal("17999"), "这是一台手机");

        IndexRequest.Builder<Object> objectBuilder = new IndexRequest.Builder<>();
        objectBuilder.index(INDEX_NAME);
        objectBuilder.document(createProduct);

        IndexResponse response = this.elasticsearchClient.index(objectBuilder.build());

        System.out.println(response.version());
    }


    /**
     * 使用异步创建
     */
    @Test
    public void asynchronousCreateIndex() {

        Product createProduct = new Product("iPhone14", UUID.randomUUID().toString(), new BigDecimal("6999"), "这是一台手机");

        this.elasticsearchAsyncClient.index(i -> i
                .index(INDEX_NAME)
                .document(createProduct)
        ).whenComplete((response, exception) -> System.out.println(exception != null ? "Failed to index, exception" : "Indexed with version " + response.version()));
    }


    /**
     * 使用原始JSON创建数据
     *
     * @throws IOException io
     */
    @Test
    public void jsonCreateIndex() throws IOException {
        Product createProduct = new Product("iPhone12", UUID.randomUUID().toString(), new BigDecimal("2999"), "这是一台手机");
        Reader input = new StringReader(JSON.toJSONString(createProduct));

        IndexResponse index = this.elasticsearchClient.index(temp -> temp
                .index(INDEX_NAME)
                .withJson(input));
        System.out.println(index.version());

    }

    @Test
    public void bulkCreateIndex() throws IOException {
        // BulkRequest包含一组操作，每个操作都是具有多个变体的类型。要创建这个请求，可以很方便地为主请求使用构建器对象，并为每个操作使用流利的 DSL。
        BulkRequest.Builder batchRequest = new BulkRequest.Builder();

        for (int i = 1; i <= 10; i++) {
            Product createProduct = new Product("HUAWEI NOTE" + i, UUID.randomUUID().toString(), new BigDecimal(i + "999"), "这是一台华为手机");
            batchRequest.operations(batch -> batch.index(idx -> idx
                    .index(INDEX_NAME)
                    .document(createProduct))
            );
        }

        BulkResponse result = this.elasticsearchClient.bulk(batchRequest.build());

        if (result.errors()) {
            System.out.println("batch add errors ");
            for (BulkResponseItem item : result.items()) {
                if (item.error() != null) {
                    System.out.println("error info :" + JSON.toJSON(item.error()));
                }
            }
        }

    }
}
