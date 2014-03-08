package com.amazonservices.mws.client;

import java.net.URI;

/**
 * Published URI's for MWS services.
 * 
 * @author mayerj
 * 
 */
public class MwsEndpoints {

    /** URI for CN production. */
    public static final URI CN_PROD;

    /** URI for DE production. */
    public static final URI DE_PROD;

    /** URI for ES production. */
    public static final URI ES_PROD;

    /** URI for EU production. */
    public static final URI EU_PROD;

    /** URI for FR production. */
    public static final URI FR_PROD;

    /** URI for IN production. */
    public static final URI IN_PROD;

    /** URI for IT production. */
    public static final URI IT_PROD;

    /** URI for JP production. */
    public static final URI JP_PROD;

    /** URI for NA production. */
    public static final URI NA_PROD;

    /** URI for UK production. */
    public static final URI UK_PROD;

    static {
        try {
            CN_PROD = new URI("https://mws.amazonservices.com.cn");
            DE_PROD = new URI("https://mws.amazonservices.de");
            ES_PROD = new URI("https://mws.amazonservices.es");
            EU_PROD = new URI("https://mws-eu.amazonservices.com");
            FR_PROD = new URI("https://mws.amazonservices.fr");
            IN_PROD = new URI("https://mws.amazonservices.in");
            IT_PROD = new URI("https://mws.amazonservices.it");
            JP_PROD = new URI("https://mws.amazonservices.jp");
            NA_PROD = new URI("https://mws.amazonservices.com");
            UK_PROD = new URI("https://mws.amazonservices.co.uk");
        } catch (Exception e) {
            throw MwsUtl.wrap(e);
        }
    }

    /** Never instantiated, but is extended. */
    protected MwsEndpoints() {
        //
    }

}
