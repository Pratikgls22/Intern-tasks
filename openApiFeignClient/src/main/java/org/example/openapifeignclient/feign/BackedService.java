package org.example.openapifeignclient.feign;

import org.openapitools.api.ApiApi;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name = "openapi-back-end",url = "http://localhost:9090")
public interface BackedService extends ApiApi {

}