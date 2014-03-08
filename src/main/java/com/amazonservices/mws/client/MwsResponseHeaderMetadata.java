package com.amazonservices.mws.client;

import java.util.Date;
import java.util.List;

/**
 * Response header metadata.
 * 
 * @author mayerj
 */
public class MwsResponseHeaderMetadata {

    /** The request id. */
    private final String requestId;

    /** The response context from response headers. */
    private final List<String> responseContext;

    /** The timestamp from response headers. */
    private final String timestamp;

    /** The max quota allowed for a quota period */
    private final Double quotaMax;

    /** Quota remaining within this quota period */
    private final Double quotaRemaining;

    /** Time that this quota period ends */
    private final Date quotaResetsAt;

    /**
     * Gets the x-mws-request-id header value.
     * 
     * @return The request id.
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Gets the x-mws-response-context header value.
     * 
     * @return The response context.
     */
    public List<String> getResponseContext() {
        return responseContext;
    }

    /**
     * Gets the x-mws-timestamp header value.
     * 
     * @return The response timestamp.
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Gets the max quota allowed for a quota period
     * (from the x-mws-quota-max header)
     *
     * @return the max quota allowed for a quota period
     */
    public Double getQuotaMax() {
        return quotaMax;
    }

    /**
     * Gets the quota remaining within this quota period
     * (from the x-mws-quota-remaining header)
     *
     * @return the quota remaining within this quota period
     */
    public Double getQuotaRemaining() {
        return quotaRemaining;
    }

    /**
     * Gets the time that this quota period ends
     * (from the x-mws-quota-resetsOn header)
     *
     * @return the time that this quota period ends
     */
    public Date getQuotaResetsAt() {
        return quotaResetsAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("requestId: ").append(requestId).append("\n");
        sb.append("responseContext: ").append(responseContext).append("\n");
        sb.append("timestamp: ").append(timestamp).append('\n');
        sb.append("quotaMax: ").append(quotaMax).append('\n');
        sb.append("quotaRemaining: ").append(quotaRemaining).append('\n');
        sb.append("quotaResetsAt: ").append(quotaResetsAt);
        return sb.toString();
    }

    /**
     * Create an immutable instance.
     * 
     * @param requestId
     * @param responseContext
     * @param timestamp
     * @param quotaMax
     * @param quotaRemaining
     * @param quotaResetsAt
     */
    public MwsResponseHeaderMetadata(String requestId, List<String> responseContext, String timestamp,
                                     Double quotaMax, Double quotaRemaining, Date quotaResetsAt) {
        this.requestId = requestId;
        this.responseContext = responseContext;
        this.timestamp = timestamp;
        this.quotaMax = quotaMax;
        this.quotaRemaining = quotaRemaining;
        this.quotaResetsAt = quotaResetsAt;
    }

    /**
     * Create an immutable instance.
     *
     * @param requestId
     * @param responseContext
     * @param timestamp
     */
    public MwsResponseHeaderMetadata(String requestId, List<String> responseContext, String timestamp) {
        this(requestId, responseContext, timestamp, null, null, null);
    }

    /**
     * Copy another instance.
     * 
     * @param a
     */
    public MwsResponseHeaderMetadata(MwsResponseHeaderMetadata a) {
        this(a.requestId,a.responseContext, a.timestamp, a.quotaMax, a.quotaRemaining, a.quotaResetsAt);
    }

}
