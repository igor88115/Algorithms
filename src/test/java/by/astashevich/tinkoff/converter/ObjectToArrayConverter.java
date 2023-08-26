package by.astashevich.tinkoff.converter;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class ObjectToArrayConverter implements ArgumentConverter {

  @Override
  public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
    return source.toString().toCharArray();
  }
}
