package spotify.Automation;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class Spotify_Api {
	public String token;
	String user_id;
	
	@BeforeMethod
	public void setup() {
		 token = " Bearer BQAkYztBuZGbIATgEyVlItPFktbpHgOyCvw9MBb9r6eUl5ydGAEssMaIoGecFEHomoX0zWEBZCdg1"
		 		+ "6y5mlQo5vbSzObx6uzDpnElHwkdpzTYvgbIIpSF1029Hktw88vPCtb5NYEGlGsd5uPsoQ1iSiDPApafQTxjg8PC7"
		 		+ "ZkST0dY8N6hAoQ8fw8sJDzhv8Pt_SnsZ4u8hnbCjmLb5XPs3yuEU1VjFE1hccnSHMpPHouxtA21Xvdmc5ePPu8GeHlgmKUZz2Bk7oM";
		
	}
	
	//----------------------------------------------USER PROFILES--------------------------------------------
	@Test(priority=1)
	public void userId() {
		Response response = given()
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", token)
				.when()
				.get("https://api.spotify.com/v1/users/"+ user_id);
		        response.prettyPrint();
		        response.then().statusCode(200);
		        Assert.assertEquals(response.statusCode(), 200);
		        String name = response.path("display_name");
		        user_id = response.path("id");
		        System.out.println(name);
	}
	
	@Test(priority=2)
	public void currentUserId() {
		Response response = given()
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", token)
				.when()
				.get("https://api.spotify.com/v1/me");
		         response.prettyPrint();
		         response.then().statusCode(200);
		         Assert.assertEquals(response.statusCode(), 200);
		         String name = response.path("display_name");
			     System.out.println(name);
	}
	
	//-------------------------------------------TRACKS----------------------------------------------------
	@Test(priority=3)
	public void getTrack() {
		Response response = given()
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", token)
				.when()
				.get("https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl?market=ES");
		         response.prettyPrint();
		         response.then().statusCode(200);
		         Assert.assertEquals(response.statusCode(), 200);
		         String name = response.path("display_name");
			     System.out.println(name);
	}
	@Test(priority=4)
	   public void getseveralTrack() {
	        Response response = given()
	           .header("Accept", "application/json")
	           .header("Content-Type", "application/json")
	           .header("Authorization", token)
	           .when()
	           .get("https://api.spotify.com/v1/tracks?market=ES&ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
                response.prettyPrint();
                response.then().statusCode(200);
                Assert.assertEquals(response.statusCode(), 200);
                String name = response.path("display_name");
       	        System.out.println(name);
}
	
	@Test(priority=5)
	   public void getTrackAudiofeature() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/audio-features/11dFghVXANMlKmJXsNCbNl");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
      	       System.out.println(name);
}
	
	
	@Test(priority=6)
	    public void getTrackAudiofeatureId() {
	         Response response = given()
	            .header("Accept", "application/json")
	            .header("Content-Type", "application/json")
	            .header("Authorization", token)
	            .when()
	            .get("https://api.spotify.com/v1/audio-features?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
                response.prettyPrint();
                response.then().statusCode(200);
                Assert.assertEquals(response.statusCode(), 200);
                String name = response.path("display_name");
       	        System.out.println(name);
}
	
	@Test(priority=7)
	   public void getTrackAudioAnalysis() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/audio-analysis/11dFghVXANMlKmJXsNCbNl");
              response.prettyPrint();
              response.then().statusCode(200);
              Assert.assertEquals(response.statusCode(), 200);
              String name = response.path("display_name");
     	      System.out.println(name);
}
	
	//----------------------------------------------------SHOWS-------------------------------------------------
	
	@Test(priority=8)
	   public void getShow() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ?market=ES");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
      	       System.out.println(name);
}
	
	
	@Test(priority=9)
	   public void getShowEpisodes() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ/episodes?market=ES&limit=10&offset=5");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
   	           System.out.println(name);
}
	
	
	@Test(priority=10)
	   public void getSeveralShows() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/shows?market=ES&ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
}
	
	
	//----------------------------------------------SEARCH-----------------------------------------------------------------
	@Test(priority=11)
	   public void searchForItem() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .pathParam("q","artist")
	          .pathParam("type","track")
	          .pathParam("market","ES")
	          .pathParam("limit","10")
	          .pathParam("offset","5")
	          .when()
	          .get("https://api.spotify.com/v1/search?q={q}&type={type}&market={market}&limit={limit}&offset={offset}");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	}

	
	
	//---------------------------------------------------PLAYLISTS--------------------------------------------------------------------------------
	
	
	@Test(priority=12)
	public void createPlaylist() {
		Response response = given()
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", token)
				.body("{\"name\":\"New Playlist\",\"description\":\"New playlist description\",\"public\":false}")
				.when()
				.post("https://api.spotify.com/v1/users/31g5z6io5loigruy2h7ul5bspuzm/playlists");
		         response.prettyPrint();
		         response.then().statusCode(201);
		         Assert.assertEquals(response.statusCode(), 201);
		         String name = response.path("display_name");
			     System.out.println(name);
	}
	
	
	@Test(priority=13)
	   public void getUserProfilePlaylist() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/users/31g5z6io5loigruy2h7ul5bspuzm/playlists");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
}
	
	@Test(priority=14)
	   public void getUserPlaylist() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/playlists/2U8akBlo0bDucYv56TcWOv");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
}
	
	@Test(priority=15)
	   public void getPlaylistItems() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/playlists/2U8akBlo0bDucYv56TcWOv/tracks");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	}
	
	@Test(priority=16)
	   public void getPlaylistCoverImage() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/playlists/2U8akBlo0bDucYv56TcWOv/images");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	
	
	}
	@Test(priority=17)
	   public void getCurrentUserPlaylist() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/me/playlists?limit=10&offset=5");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	
	
	}
	//-----------------------------------------------ALUBUM----------------------------------------------------------------
	
	
	@Test(priority=18)
	   public void getSeveralAlbums() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc&market=ES");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	
	}
	
	@Test(priority=19)
	   public void getAlbums() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy?market=ES");
              response.prettyPrint();
              response.then().statusCode(200);
              Assert.assertEquals(response.statusCode(), 200);
              String name = response.path("display_name");
	          System.out.println(name);
	
	}
	
	@Test(priority=20)
	   public void getAlbumsTracks() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks?market=ES&limit=10&offset=5");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	
	}
	
	
	//-----------------------------------------------ARTISTS---------------------------------------------------------------
	
	
	@Test(priority=21)
	   public void getSeveralArtists() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/artists?ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	}
	
	
	@Test(priority=22)
	   public void getArtists() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	}
	
	@Test(priority=23)
	   public void getArtistsTopTracks() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks?market=ES");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	}
	
	@Test(priority=24)
	   public void getArtistsRelatedArtists() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/related-artists");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	
	}
	
	@Test(priority=25)
	   public void getArtistsAlbums() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/albums?include_groups=single%2Cappears_on&market=ES&limit=10&offset=5");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	}
	
	//------------------------------------------------AUDIOBOOKS----------------------------------------------------------
	
	@Test(priority=26)
	   public void getSeveralAudiobooks() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/audiobooks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B&market=ES");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	}
	
	
	
	@Test(priority=27)
	   public void getaAnAudiobooks() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/audiobooks/38bS44xjbVVZ3No3ByF1dJ?market=ES");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	}
	
	@Test(priority=28)
	   public void getaAudiobooksChapters() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/audiobooks/38bS44xjbVVZ3No3ByF1dJ/chapters?market=ES&limit=10&offset=5");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	}
	//-------------------------------------------------BROWES-------------------------------------------------------------------
	
	
	@Test(priority=29)
	   public void getRecommendations() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/recommendations?limit=10&market=ES&seed_artists=4NHQUGzhtTLFvgF5SZesLK&seed_genres=classical%2Ccountry&seed_tracks=0c6xIDDpzE81m2q797ordA");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	}
	
	@Test(priority=30)
	   public void getNewReleases() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/browse/new-releases?country=SE&limit=10&offset=5");
               response.prettyPrint();
              response.then().statusCode(200);
              Assert.assertEquals(response.statusCode(), 200);
              String name = response.path("display_name");
	          System.out.println(name);
	}
	
	
	@Test(priority=31)
	   public void getFeaturedPlaylists() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/browse/featured-playlists?country=SE&locale=sv_SE&timestamp=2014-10-23T09%3A00%3A00.000Z&limit=10&offset=5");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	}
	
	
	@Test(priority=32)
	   public void getCategoryPlaylists() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/browse/categories/dinner/playlists?country=SE&limit=10&offset=5");
            response.prettyPrint();
            response.then().statusCode(200);
            Assert.assertEquals(response.statusCode(), 200);
            String name = response.path("display_name");
	           System.out.println(name);
	}
	
	@Test(priority=33)
	   public void getSingleBrowseCategory() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/browse/categories/dinner?country=SE&locale=sv_SE");
         response.prettyPrint();
         response.then().statusCode(200);
         Assert.assertEquals(response.statusCode(), 200);
         String name = response.path("display_name");
	           System.out.println(name);
	}
	
	@Test(priority=34)
	   public void getSeveralBrowseCategory() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/browse/categories?country=SE&locale=sv_SE&limit=10&offset=5");
      response.prettyPrint();
      response.then().statusCode(200);
      Assert.assertEquals(response.statusCode(), 200);
      String name = response.path("display_name");
	           System.out.println(name);
	}
	
	
	
	@Test(priority=35)
	   public void getAvailableGenreSeeds() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
   response.prettyPrint();
   response.then().statusCode(200);
   Assert.assertEquals(response.statusCode(), 200);
   String name = response.path("display_name");
	           System.out.println(name);
	}
	
	//------------------------------------------------------CHAPTERS-----------------------------------------------------------
	
	
	@Test(priority=36)
	   public void getSeveralChapters() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/chapters?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B&market=ES");
response.prettyPrint();
response.then().statusCode(200);
Assert.assertEquals(response.statusCode(), 200);
String name = response.path("display_name");
	           System.out.println(name);
	}
	
	//--------------------------------------------------Episodes----------------------------------------------------------
	
	
	@Test(priority=37)
	   public void getSeveralEpisodes() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/episodes?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf&market=ES");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	}
	
	
	@Test(priority=38)
	   public void getEpisodes() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/episodes/512ojhOuo1ktJprKbVcKyQ?market=ES");
               response.prettyPrint();
               response.then().statusCode(200);
               Assert.assertEquals(response.statusCode(), 200);
               String name = response.path("display_name");
	           System.out.println(name);
	}
	
	
	//-------------------------------------------------------FOLLOWS-----------------------------------------------------------
	
	
	@Test(priority=39)
	   public void CheckifUsersFollowPlaylist() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .when()
	          .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers/contains?ids=jmperezperez%2Cthelinmichael%2Cwizzler");
            response.prettyPrint();
            response.then().statusCode(200);
            Assert.assertEquals(response.statusCode(), 200);
            String name = response.path("display_name");
	           System.out.println(name);
	}
	
	
	
	


	@Test(priority=40)
	   public void search2() {
	        Response response = given()
	          .header("Accept", "application/json")
	          .header("Content-Type", "application/json")
	          .header("Authorization", token)
	          .queryParam("q", "artist")
	          .queryParam("type","track")
	          .when()
	          .get("https://api.spotify.com/v1/search");
	}
}
