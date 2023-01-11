package ru.egormit.gateway.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ws.soap.client.SoapFaultClientException;
import ru.egormit.library.ErrorResponse;

import javax.servlet.http.HttpServletResponse;

/**
 * {@link ControllerAdvice}, обрабатывающий возникающие исключения.
 *
 * @author Egor Mitrofanov.
 */
@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    /**
     * Обработка бизнес исключений.
     *
     * @param ex исключение.
     * @return ошибка приложения.
     */
    @ResponseBody
    @ExceptionHandler(SoapFaultClientException.class)
    public ErrorResponse handleApplicationException(SoapFaultClientException ex, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        log.debug("Exception happened {}", ex.getMessage());
        return ErrorResponse.of(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

}
