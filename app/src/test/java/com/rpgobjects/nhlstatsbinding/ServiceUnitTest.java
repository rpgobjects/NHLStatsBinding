package com.rpgobjects.nhlstatsbinding;

import com.rpgobjects.nhlstatsbinding.model.NHLDataTypes;
import com.rpgobjects.nhlstatsbinding.model.NHLService;
import com.rpgobjects.nhlstatsbinding.model.ServiceGenerator;

import org.junit.Test;
import static org.junit.Assert.*;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ServiceUnitTest {
    @Test
    public void goalies_have_stats() throws Exception {
        NHLService  service = ServiceGenerator.createService(NHLService.class);
        Call<NHLDataTypes.StatsSearchResult>  call = service.getGoalieStats("seasonId=20162017 and gameTypeId=2 and playerPositionCode=\"G\"",
                "gamesPlayed>=14",
                "[{\"property\":\"goalsAgainstAverage\",\"direction\":\"ASC\"}]");

        Response<NHLDataTypes.StatsSearchResult> response = call.execute();
        NHLDataTypes.StatsSearchResult statsSearchResult = response.body();
        assertEquals(statsSearchResult.playerList.get(0).playerFirstName,"Devan");

        Call<NHLDataTypes.PlayerResult> playerResultCall = service.getGoalieDetails("8471227");
        Response<NHLDataTypes.PlayerResult> playerResultResponse = playerResultCall.execute();
        NHLDataTypes.PlayerResult playerResult = playerResultResponse.body();
        assertEquals(playerResult.getPlayer().firstName,"Devan");
    }
}