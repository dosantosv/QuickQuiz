import com.example.applicationquiz.FunctionResponse

open class FunctionResponseData<T>(errorList: MutableList<String>?, mustShowError: Boolean, var responseData: T?) :
    FunctionResponse() {

    class Success<T> (responseData: T? = null): FunctionResponseData<T>(null, false, responseData)

    class Error<T>(errorList: MutableList<String>, mustShowError: Boolean = true, responseData: T? = null)
        : FunctionResponseData<T>(errorList, mustShowError, responseData){

        constructor(error: String, mustShowError: Boolean = true, responseData: T? = null) : this (mutableListOf(error), mustShowError, responseData)

    }
}