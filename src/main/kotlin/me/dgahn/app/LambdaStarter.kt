package me.dgahn.app

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider
import software.amazon.awssdk.core.SdkBytes
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.lambda.LambdaClient
import software.amazon.awssdk.services.lambda.model.InvokeRequest

fun main() {
    val awsLambda: LambdaClient = LambdaClient.builder()
        .region(Region.AP_NORTHEAST_2)
        .credentialsProvider(ProfileCredentialsProvider.create())
        .build()
    val functionName = "reverseString"

    val payload = SdkBytes.fromUtf8String("\"abc\"") // 무조건 Json으로 작성해야 함.
    // Setup an InvokeRequest.
    val request = InvokeRequest.builder()
        .functionName(functionName)
        .payload(payload)
        .build()
    val res = awsLambda.invoke(request)
    val value = res.payload().asUtf8String()
    println(value)
}