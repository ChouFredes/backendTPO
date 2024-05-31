package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "La order line que se intenta agregar esta duplicada")
public class OrderLineDuplicateException extends Exception{
}
