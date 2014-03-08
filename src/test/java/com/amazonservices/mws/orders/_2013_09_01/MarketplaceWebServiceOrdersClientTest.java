package com.amazonservices.mws.orders._2013_09_01;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import javax.management.RuntimeErrorException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.amazonservices.mws.client.MwsConnection;
import com.amazonservices.mws.client.MwsException;
import com.amazonservices.mws.orders._2013_09_01.MarketplaceWebServiceOrdersClient.RequestType;
import com.amazonservices.mws.orders._2013_09_01.model.GetOrderRequest;
import com.amazonservices.mws.orders._2013_09_01.model.GetOrderResponse;
import com.amazonservices.mws.orders._2013_09_01.model.GetServiceStatusRequest;
import com.amazonservices.mws.orders._2013_09_01.model.GetServiceStatusResponse;
import com.amazonservices.mws.orders._2013_09_01.model.ListOrderItemsByNextTokenRequest;
import com.amazonservices.mws.orders._2013_09_01.model.ListOrderItemsByNextTokenResponse;
import com.amazonservices.mws.orders._2013_09_01.model.ListOrderItemsRequest;
import com.amazonservices.mws.orders._2013_09_01.model.ListOrderItemsResponse;
import com.amazonservices.mws.orders._2013_09_01.model.ListOrdersByNextTokenRequest;
import com.amazonservices.mws.orders._2013_09_01.model.ListOrdersByNextTokenResponse;
import com.amazonservices.mws.orders._2013_09_01.model.ListOrdersRequest;
import com.amazonservices.mws.orders._2013_09_01.model.ListOrdersResponse;

public class MarketplaceWebServiceOrdersClientTest {

  private final static String ACCESS_KEY = "testAccessKey";
  private final static String SECRET_KEY = "testSECRET_KEY";
  private final static String SERVICE_URL = "http://local.service.test";

  private MarketplaceWebServiceOrdersClient uut;

  private MarketplaceWebServiceOrdersConfig mockConfig;
  private MwsConnection mockConnection;

  @Before
  public void setup() {

    mockConfig = Mockito.mock(MarketplaceWebServiceOrdersConfig.class);
    mockConnection = Mockito.mock(MwsConnection.class);
    when(mockConfig.copyConnection()).thenReturn(mockConnection);
    when(mockConfig.getServicePath()).thenReturn(SERVICE_URL);

    uut = new MarketplaceWebServiceOrdersClient(ACCESS_KEY, SECRET_KEY, mockConfig);

    Mockito.verify(mockConfig).copyConnection();
    Mockito.verify(mockConfig).getServicePath();
    Mockito.verifyNoMoreInteractions(mockConfig);
    Mockito.verify(mockConnection).setAwsAccessKeyId(ACCESS_KEY);
    Mockito.verify(mockConnection).setAwsSecretKeyId(SECRET_KEY);
    Mockito.verify(mockConnection).setApplicationName("MarketplaceWebServiceOrders");
    Mockito.verify(mockConnection).setApplicationVersion("2013-09-01");
    Mockito.verify(mockConnection).setLibraryVersion("2013-09-01");
    Mockito.verifyNoMoreInteractions(mockConnection);
  }

  @Test
  public void getOrders() {

    GetOrderRequest request = new GetOrderRequest();

    uut.getOrder(request);

    RequestType type = new RequestType("GetOrder", GetOrderResponse.class, SERVICE_URL);
    Mockito.verify(mockConnection).call(type, request);
    Mockito.verifyNoMoreInteractions(mockConnection);
  }

  @Test
  public void getOrdersWhenBadRequestExceptionIsThrown() {

    GetOrderRequest request = new GetOrderRequest();
    RequestType type = new RequestType("GetOrder", GetOrderResponse.class, SERVICE_URL);
    Mockito.when(mockConnection.call(type, request)).thenThrow(
        new MwsException(400, "Bad requst", new RuntimeException("test")));
    try {
      uut.getOrder(request);
      fail();
    } catch (Exception e) {
      Mockito.verify(mockConnection).call(type, request);
      Mockito.verifyNoMoreInteractions(mockConnection);

    }
  }

  @Test
  public void getServiceStatus() {

    GetServiceStatusRequest request = new GetServiceStatusRequest();

    uut.getServiceStatus(request);

    RequestType type = new RequestType("GetServiceStatus", GetServiceStatusResponse.class, SERVICE_URL);
    Mockito.verify(mockConnection).call(type, request);
    Mockito.verifyNoMoreInteractions(mockConnection);
  }

  @Test
  public void listOrderItems() {

    ListOrderItemsRequest request = new ListOrderItemsRequest();

    uut.listOrderItems(request);

    RequestType type = new RequestType("ListOrderItems", ListOrderItemsResponse.class, SERVICE_URL);
    Mockito.verify(mockConnection).call(type, request);
    Mockito.verifyNoMoreInteractions(mockConnection);
  }

  @Test
  public void listOrderItemsByNextToken() {

    ListOrderItemsByNextTokenRequest request = new ListOrderItemsByNextTokenRequest();
    uut.listOrderItemsByNextToken(request);

    RequestType type = new RequestType("ListOrderItemsByNextToken", ListOrderItemsByNextTokenResponse.class,
        SERVICE_URL);
    Mockito.verify(mockConnection).call(type, request);
    Mockito.verifyNoMoreInteractions(mockConnection);
  }

  @Test
  public void listOrder() {

    ListOrdersRequest request = new ListOrdersRequest();
    uut.listOrders(request);

    RequestType type = new RequestType("ListOrders", ListOrdersResponse.class, SERVICE_URL);
    Mockito.verify(mockConnection).call(type, request);
    Mockito.verifyNoMoreInteractions(mockConnection);
  }

  @Test
  public void listOrdersByNextToken() {

    ListOrdersByNextTokenRequest request = new ListOrdersByNextTokenRequest();
    uut.listOrdersByNextToken(request);

    RequestType type = new RequestType("ListOrdersByNextToken", ListOrdersByNextTokenResponse.class, SERVICE_URL);
    Mockito.verify(mockConnection).call(type, request);
    Mockito.verifyNoMoreInteractions(mockConnection);
  }

}
