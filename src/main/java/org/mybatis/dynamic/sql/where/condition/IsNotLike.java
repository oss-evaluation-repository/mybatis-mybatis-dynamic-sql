/*
 *    Copyright 2016-2023 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.dynamic.sql.where.condition;

import java.util.function.Function;
import java.util.function.Predicate;

import org.mybatis.dynamic.sql.AbstractSingleValueCondition;

public class IsNotLike<T> extends AbstractSingleValueCondition<T> {
    private static final IsNotLike<?> EMPTY = new IsNotLike<Object>(null) {
        @Override
        public boolean shouldRender() {
            return false;
        }
    };

    public static <T> IsNotLike<T> empty() {
        @SuppressWarnings("unchecked")
        IsNotLike<T> t = (IsNotLike<T>) EMPTY;
        return t;
    }

    protected IsNotLike(T value) {
        super(value);
    }

    @Override
    public String renderCondition(String columnName, String placeholder) {
        return columnName + " not like " + placeholder; //$NON-NLS-1$
    }

    public static <T> IsNotLike<T> of(T value) {
        return new IsNotLike<>(value);
    }

    @Override
    public IsNotLike<T> filter(Predicate<? super T> predicate) {
        return filterSupport(predicate, IsNotLike::empty, this);
    }

    /**
     * If renderable, apply the mapping to the value and return a new condition with the new value. Else return a
     * condition that will not render (this).
     *
     * @param mapper
     *            a mapping function to apply to the value, if renderable
     * @param <R>
     *            type of the new condition
     *
     * @return a new condition with the result of applying the mapper to the value of this condition, if renderable,
     *         otherwise a condition that will not render.
     */
    public <R> IsNotLike<R> map(Function<? super T, ? extends R> mapper) {
        return mapSupport(mapper, IsNotLike::new, IsNotLike::empty);
    }
}
