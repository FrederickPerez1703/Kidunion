package com.kidunion.utilities.exceptions;

import com.kidunion.children.domain.exception.ChildreException;
import com.kidunion.members.domain.exception.MemberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class AdviceException {

    @ExceptionHandler(ChildreException.class)
    public ResponseEntity<String> getChildreException(ChildreException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(MemberException.class)
    public ResponseEntity<String> getMemberException(MemberException msj) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msj.getMessage());
    }
}
