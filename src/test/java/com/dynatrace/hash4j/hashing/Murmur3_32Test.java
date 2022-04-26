/*
 * Copyright 2022 Dynatrace LLC
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
package com.dynatrace.hash4j.hashing;

class Murmur3_32Test extends AbstractHashCalculatorTest {

  private static final AbstractHasher32 HASHER = Murmur3_32.create();

  @Override
  protected HashCalculator createHashCalculator() {
    return HASHER.newHashCalculator();
  }

  @Override
  protected Hasher32 createHasher() {
    return Hashing.murmur3_32();
  }
}
