/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;

import java.io.FileNotFoundException;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class Refund {
    private ApiConnection apiConnection;
    private Keys key= new Keys();
    Endpoints end= new Endpoints();

    public String ref;
    public JSONObject refund(){
        this.apiConnection = new ApiConnection(end.getRefundEndPoint());
        ApiQuery api= new ApiQuery();

        api.putParams("ref", ref);
        api.putParams("seckey", key.getSecretKey());


        return this.apiConnection.connectAndQuery(api);
    }
}
