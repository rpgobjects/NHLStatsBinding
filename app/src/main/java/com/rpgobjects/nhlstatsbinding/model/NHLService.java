package com.rpgobjects.nhlstatsbinding.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by chris on 1/24/17.
 */

public interface NHLService {
    //http://www.nhl.com/stats/rest/grouped/goalies/goalie_basic/season/goaliesummary?cayenneExp=seasonId=20162017%20and%20gameTypeId=2%20and%20playerPositionCode=%22G%22&factCayenneExp=gamesPlayed%3E=14&sort=[{%22property%22:%22goalsAgainstAverage%22,%22direction%22:%22ASC%22}]
    //http://www.nhl.com/stats/rest/grouped/goalies/goalie_basic/season/goaliesummary?cayenneExp=seasonId=20162017 and gameTypeId=2 and playerPositionCode="G"&factCayenneExp=gamesPlayed>=14&sort=[{"property":"goalsAgainstAverage","direction":"ASC"}]

    @GET("goalies/goalie_basic/season/goaliesummary")
    Call<NHLDataTypes.StatsSearchResult> getGoalieStats(@Query("cayenneExp") String cayenneExp, @Query("factCayenneExp") String factCayenneExp, @Query("sort") String sort);

//https://statsapi.web.nhl.com/api/v1/people/8471227?expand=person.stats&stats=yearByYear,careerRegularSeason&expand=stats.team&site=en_nhl
    @GET("https://statsapi.web.nhl.com/api/v1/people/{id}?expand=person.stats&stats=yearByYear,careerRegularSeason&expand=stats.team&site=en_nhl")
    Call<NHLDataTypes.PlayerResult> getGoalieDetails(@Path("id") String id);
}
