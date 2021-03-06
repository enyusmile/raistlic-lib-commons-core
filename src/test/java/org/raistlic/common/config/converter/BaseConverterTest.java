/*
 * Copyright 2015 Lei CHEN (raistlic@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.raistlic.common.config.converter;

import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.raistlic.common.codec.Codec;

import static org.raistlic.common.postcondition.Postcondition.assertThat;

/**
 * @author Lei Chen (2015-09-15)
 */
@RunWith(JUnitParamsRunner.class)
public abstract class BaseConverterTest {

  abstract Codec<?, String> getConverter();

  @Test
  public void decodeWithNullDest() {

    assertThat(getConverter().decode(null)).isNull();
  }

  @Test
  public void encodeWithNullSrc() {

    assertThat(getConverter().encode(null)).isNull();
  }
}
