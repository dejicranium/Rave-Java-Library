/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;



import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class Fees {
    private ApiConnection apiConnection;
    Keys key= new Keys();
    Endpoints end= new Endpoints();

    public String amount,currency,card6;
    
    public JSONObject getFees(){   

      this.apiConnection = new ApiConnection(end.getFeesEndPoint());

      ApiQuery api= new ApiQuery();
      api.putParams("amount", amount);
      api.putParams("PBFPubKey", key.getPublicKey());
      api.putParams("currency", currency);
      api.putParams("ptype",2);


      return this.apiConnection.connectAndQuery(api);
    }
     /*used only when the user has entered first 6digits of their card number,
     it also helps determine international fees on the transaction if the card being used is an international card
     */

    public JSONObject getFeesForCard6(){

      this.apiConnection = new ApiConnection(end.getFeesEndPoint());

      ApiQuery api= new ApiQuery();
      api.putParams("amount", amount);
      api.putParams("PBFPubKey", key.getPublicKey());
      api.putParams("currency", currency);
      api.putParams("ptype",2);
      api.putParams("card6", card6);

      return this.apiConnection.connectAndQuery(api);
    }
}
