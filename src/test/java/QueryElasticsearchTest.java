import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.RangeQuery;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.indices.ElasticsearchIndicesClient;
import co.elastic.clients.json.JsonData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yishenheng.rapid.data.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author yishenheng
 * @date 2022/9/21 14:04
 */
@Service
public class QueryElasticsearchTest extends BaseTest {


    @Autowired
    private ElasticsearchClient elasticsearchClient;

    private static final String INDEX_NAME = "products";

    @Test
    public void getIndexById() throws IOException {

        GetResponse<JSONObject> productInfo = this.elasticsearchClient
                .get(q -> q.index(INDEX_NAME)
                        .id("EoicXoMBWQoQ98qNFT7I"), JSONObject.class);


        if (!productInfo.found()) {
            System.out.println("data is null");
            return;
        }

        System.out.println(JSON.toJSONString(productInfo.source()));


    }


    @Test
    public void getIndexData() throws IOException {
        SearchResponse<Product> response = this.elasticsearchClient.search(i -> i
                        .index(INDEX_NAME)
                , Product.class);

        List<Hit<Product>> productHits = response.hits().hits();
        for (Hit<Product> productHit : productHits) {
            System.out.println(JSON.toJSONString(productHit.source()));
        }

    }

    @Test
    public void queryIndex() throws IOException {
        SearchResponse<Product> response = this.elasticsearchClient.search(q -> q.
                        index(INDEX_NAME)
                        .query(query -> query
                                .match(m -> m
                                        .field("name")
                                        .query("huawei")))
                , Product.class);

        for (Hit<Product> hit : response.hits().hits()) {
            System.out.println(JSON.toJSON(hit.source()));
        }

    }

    @Test
    public void queryNestedIndex() throws IOException {
        // name = huawei
        Query byName = MatchQuery.of(m -> m.field("name").query("huawei"))._toQuery();

        // price >= 10000
        Query byPrice = RangeQuery.of(r -> r.field("price").gte(JsonData.of("5999")))._toQuery();

        SearchResponse<Product> response = this.elasticsearchClient.search(s -> s.
                        index(INDEX_NAME)
                        .query(query -> query
                                .bool(m -> m
                                        .must(byName)
                                        .must(byPrice)
                                )
                        )
                , Product.class);


        for (Hit<Product> hit : response.hits().hits()) {
            System.out.println(JSON.toJSON(hit.source()));
        }

    }

}
