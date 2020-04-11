package salem.shah.ppmtool.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {
    public ResponseEntity<?> MapValidationService(BindingResult result){
        // This will create a message for bad request
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            // this will return the messages that we wrote in Project.java file for every filed.
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
            //return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);

            //this will return a object list with mor information
            //return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}

