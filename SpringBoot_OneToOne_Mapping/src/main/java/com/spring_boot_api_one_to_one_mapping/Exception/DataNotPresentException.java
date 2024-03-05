package com.spring_boot_api_one_to_one_mapping.Exception;

public class DataNotPresentException extends Exception{

    String message;

    public DataNotPresentException(String message)
    {
        super(message);
    }

}
