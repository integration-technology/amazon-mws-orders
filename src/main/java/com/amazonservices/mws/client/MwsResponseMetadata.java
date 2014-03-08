package com.amazonservices.mws.client;

/**
 * Response metadata.
 * 
 * @author mayerj
 */
public class MwsResponseMetadata extends AbstractMwsObject {

    /** The request id. */
    private String requestId;

    /**
     * Gets the request id.
     * 
     * @return The request id.
     */
    public String getRequestId() {
        return requestId;
    }
    /**
     * Set the request id.
     * 
     * @param value
     *            The request id.
     * 
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    @Override
    public void writeFragmentTo(MwsWriter w) {
        w.write("RequestId", requestId);
    }

    @Override
    public void readFragmentFrom(MwsReader r) {
        requestId = r.read("RequestId", String.class);
    }

    @Override
    public void writeTo(MwsWriter w)  {
        String name = "ResponseMetadata";
        w.beginObject(name);
        writeFragmentTo(w);
        w.endObject(name);
    }

}
