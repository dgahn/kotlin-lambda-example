package me.dgahn.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler

class ReverseHandler: RequestHandler<String, String> {
    override fun handleRequest(input: String, context: Context?): String {
        return input.reversed()
    }
}