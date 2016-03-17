package org.raistlic.common.expectation;

import org.raistlic.common.precondition.InvalidParameterException;

import java.util.Collection;
import java.util.function.Function;

/**
 * @author Lei Chen (2015-12-29)
 */
final class DefaultExpectedCases implements ExpectedCases {

  private final Function<String, ? extends RuntimeException> exceptionMapper;

  DefaultExpectedCases(Function<String, ? extends RuntimeException> exceptionMapper) {

    if (exceptionMapper == null) {
      throw new InvalidParameterException("'exceptionProvider' cannot be null.");
    }
    this.exceptionMapper = exceptionMapper;
  }

  @Override
  public <V> GeneralExpectation<V> expect(V value) {

    return expect(value, null);
  }

  @Override
  public <V> GeneralExpectation<V> expect(V value, String name) {

    return new GeneralExpectation<V>(value, name, exceptionMapper);
  }

  @Override
  public StringExpectation expect(String value) {

    return expect(value, null);
  }

  @Override
  public StringExpectation expect(String value, String name) {

    return new StringExpectation(value, name, exceptionMapper);
  }

  @Override
  public <E, C extends Collection<E>> CollectionExpectation<E, C> expect(C collection) {

    return new CollectionExpectation<>(collection, null, exceptionMapper);
  }

  @Override
  public <E, C extends Collection<E>> CollectionExpectation<E, C> expect(C collection, String name) {

    return new CollectionExpectation<>(collection, name, exceptionMapper);
  }

  @Override
  public <N extends Number & Comparable<N>> NumberExpectation<N> expect(N value) {

    return expect(value, null);
  }

  @Override
  public <N extends Number & Comparable<N>> NumberExpectation<N> expect(N value, String name) {

    return new NumberExpectation<>(value, name, exceptionMapper);
  }

  @Override
  public BooleanExpectation.Boxed expect(Boolean value) {

    return expect(value, null);
  }

  @Override
  public BooleanExpectation.Boxed expect(Boolean value, String name) {

    return new BooleanExpectation.Boxed(value, name, exceptionMapper);
  }

  @Override
  public BooleanExpectation.Primitive expect(boolean value) {

    return expect(value, null);
  }

  @Override
  public BooleanExpectation.Primitive expect(boolean value, String name) {

    return new BooleanExpectation.Primitive(value, name, exceptionMapper);
  }

  @Override
  public void assertThat(boolean assertion, String message) {

    if (!assertion) {
      throw exceptionMapper.apply(message);
    }
  }
}