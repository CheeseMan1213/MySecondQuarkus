package org.acme.dynamodb;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

//@Named("amazonDynamodbQuickstart")
//public class AwsLambdaHandler implements RequestHandler<Map<String, String>, String> {
//	@Override
//	public String handleRequest(Map<String, String> event, Context context) {
//		return "Hello amazon-dynamodb-quickstart";
//	}
//}

@Named("amazonDynamodbQuickstart")
@ApplicationScoped
public class AwsLambdaHandler implements RequestHandler<Map<String, String>, List<Fruit>> {

//	@Inject
	@Autowired
	FruitSyncService service;

	@Override
	public List<Fruit> handleRequest(Map<String, String> event, Context context) {
//		List<Fruit> fruit = service.findAll();
//		return fruit.get(0).getName();
//		return fruit.size();
//		return service.findAll().size();
//		return 25;
		return service.findAll();
	}
}
