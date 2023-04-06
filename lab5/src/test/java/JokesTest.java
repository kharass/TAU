import org.example.Jokes;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JokesTest {
    Jokes jokes = mock(Jokes.class);

    String url = "https://api.chucknorris.io/jokes";
    @Test
    public void randomChuckNorrisJokeTest(){
        when(jokes.randomChuckNorrisJoke(url+"/random")).thenReturn("{\n" +
                "    \"categories\": [],\n" +
                "    \"created_at\": \"2020-01-05 13:42:29.855523\",\n" +
                "    \"icon_url\": \"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\n" +
                "    \"id\": \"IhnjAUC8QMCEnqyyvbXy9A\"\n" +
                "    \"updated_at\": \"2020-01-05 13:42:29.855523\"\n" +
                "    \"url\": \"https://api.chucknorris.io/jokes/IhnjAUC8QMCEnqyyvbXy9A\"\n" +
                "    \"value\": \"In 3rd grade , Chuck Norris wrote tthat 1+1=4 , and was instantly promoted to 8th grade.\"\n" +
                "}");
        String randomChuckNorrisJoke = jokes.randomChuckNorrisJoke(url+"/random");
        Assert.assertEquals(randomChuckNorrisJoke,"{\n" +
                "    \"categories\": [],\n" +
                "    \"created_at\": \"2020-01-05 13:42:29.855523\",\n" +
                "    \"icon_url\": \"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\n" +
                "    \"id\": \"IhnjAUC8QMCEnqyyvbXy9A\"\n" +
                "    \"updated_at\": \"2020-01-05 13:42:29.855523\"\n" +
                "    \"url\": \"https://api.chucknorris.io/jokes/IhnjAUC8QMCEnqyyvbXy9A\"\n" +
                "    \"value\": \"In 3rd grade , Chuck Norris wrote tthat 1+1=4 , and was instantly promoted to 8th grade.\"\n" +
                "}");
    }

   @Test
    public void allCategoryTest(){
        when(jokes.allCategory(url+"/categories")).thenReturn("[\n" +
                "    \"animal\",\n" +
                "    \"career\",\n" +
                "    \"celebrity\",\n" +
                "    \"dev\",\n" +
                "    \"explicit\",\n" +
                "    \"fashion\",\n" +
                "    \"food\",\n" +
                "    \"history\",\n" +
                "    \"money\",\n" +
                "    \"movie\",\n" +
                "    \"music\",\n" +
                "    \"political\",\n" +
                "    \"religion\",\n" +
                "    \"science\",\n" +
                "    \"sport\",\n" +
                "    \"travel\",\n" +
                "}");
        String allCategory = jokes.allCategory(url+"/categories");
        Assert.assertEquals(allCategory,"[\n" +
                "    \"animal\",\n" +
                "    \"career\",\n" +
                "    \"celebrity\",\n" +
                "    \"dev\",\n" +
                "    \"explicit\",\n" +
                "    \"fashion\",\n" +
                "    \"food\",\n" +
                "    \"history\",\n" +
                "    \"money\",\n" +
                "    \"movie\",\n" +
                "    \"music\",\n" +
                "    \"political\",\n" +
                "    \"religion\",\n" +
                "    \"science\",\n" +
                "    \"sport\",\n" +
                "    \"travel\",\n" +
                "}");
    }
   @Test
    public void searchTest(){
        when(jokes.search(url+"/search?query=squid")).thenReturn("{\n" +
                "    \"total\": 1,\n" +
                "    \"result\": \n" +
                "    [{\n" +
                "    \"categories\": [],\n" +
                "    \"created_at\": \"2020-01-05 13:42:19.104863\",\n" +
                "    \"icon_url\": \"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\n" +
                "    \"id\": \"xzfLCnypTpSRnPTe9AkexQ\"\n" +
                "    \"updated_at\": \"2020-01-05 13:42:19.104863\"\n" +
                "    \"url\": \"https://api.chucknorris.io/jokes/xzfLCnypTpSRnPTe9AkexQ\"\n" +
                "    \"value\": \"Chuck Norris keeps a pet squid in his toilet to wipe his ass with.\"\n" +
                "}]}");
        String search = jokes.search(url+"/search?query=squid");
        Assert.assertEquals(search,"{\n" +
                "    \"total\": 1,\n" +
                "    \"result\": \n" +
                "    [{\n" +
                "    \"categories\": [],\n" +
                "    \"created_at\": \"2020-01-05 13:42:19.104863\",\n" +
                "    \"icon_url\": \"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\n" +
                "    \"id\": \"xzfLCnypTpSRnPTe9AkexQ\"\n" +
                "    \"updated_at\": \"2020-01-05 13:42:19.104863\"\n" +
                "    \"url\": \"https://api.chucknorris.io/jokes/xzfLCnypTpSRnPTe9AkexQ\"\n" +
                "    \"value\": \"Chuck Norris keeps a pet squid in his toilet to wipe his ass with.\"\n" +
                "}]}");
    }

    @Test
    public void randomCategoryTest(){
        when(jokes.randomCategory(url+"/random?category=money")).thenReturn("{\n" +
                "    \"categories\": [\"money\"],\n" +
                "    \"created_at\": \"2020-01-05 13:42:21.179347\",\n" +
                "    \"icon_url\": \"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\n" +
                "    \"id\": \"gnRIdaF_QqyrE0G-GdCuWA\"\n" +
                "    \"updated_at\": \"2020-05-22 06:16:41.133769\"\n" +
                "    \"url\": \"https://api.chucknorris.io/jokes/gnRIdaF_QqyrE0G-GdCuWA\"\n" +
                "    \"value\": \"Chuck Norris will not be printed on money; no one pays out Chuck Norris. Ever.\"\n" +
                "}");
        String randomCategory = jokes.randomCategory(url+"/random?category=money");
        Assert.assertEquals(randomCategory,"{\n" +
                "    \"categories\": [\"money\"],\n" +
                "    \"created_at\": \"2020-01-05 13:42:21.179347\",\n" +
                "    \"icon_url\": \"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\n" +
                "    \"id\": \"gnRIdaF_QqyrE0G-GdCuWA\"\n" +
                "    \"updated_at\": \"2020-05-22 06:16:41.133769\"\n" +
                "    \"url\": \"https://api.chucknorris.io/jokes/gnRIdaF_QqyrE0G-GdCuWA\"\n" +
                "    \"value\": \"Chuck Norris will not be printed on money; no one pays out Chuck Norris. Ever.\"\n" +
                "}");
    }
}