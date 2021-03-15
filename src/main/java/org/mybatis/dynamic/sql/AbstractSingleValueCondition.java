/*
 *    Copyright 2016-2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.dynamic.sql;

import java.util.Objects;
import java.util.function.Supplier;

public abstract class AbstractSingleValueCondition<T> implements VisitableCondition<T> {
    protected final Supplier<T> valueSupplier;

    protected AbstractSingleValueCondition(Supplier<T> valueSupplier) {
        this.valueSupplier = Objects.requireNonNull(valueSupplier);
    }

    public T value() {
        return valueSupplier.get();
    }

    @Override
    public <R> R accept(ConditionVisitor<T, R> visitor) {
        return visitor.visit(this);
    }

    public abstract String renderCondition(String columnName, String placeholder);
}
