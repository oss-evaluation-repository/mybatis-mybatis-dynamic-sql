/*
 *    Copyright 2016-2024 the original author or authors.
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
package org.mybatis.dynamic.sql.select;

import org.mybatis.dynamic.sql.util.Buildable;

public interface PagingDSL<T> {
    default LimitFinisher<T> limit(long limit) {
        return limitWhenPresent(limit);
    }

    LimitFinisher<T> limitWhenPresent(Long limit);

    default OffsetFirstFinisher<T> offset(long offset) {
        return offsetWhenPresent(offset);
    }

    OffsetFirstFinisher<T> offsetWhenPresent(Long offset);

    default FetchFirstFinisher<T> fetchFirst(long fetchFirstRows) {
        return fetchFirstWhenPresent(fetchFirstRows);
    }

    FetchFirstFinisher<T> fetchFirstWhenPresent(Long fetchFirstRows);

    interface LimitFinisher<T> extends Buildable<T> {
        default Buildable<T> offset(long offset) {
            return offsetWhenPresent(offset);
        }

        Buildable<T> offsetWhenPresent(Long offset);
    }

    interface OffsetFirstFinisher<T> extends Buildable<T> {
        default FetchFirstFinisher<T> fetchFirst(long fetchFirstRows) {
            return fetchFirstWhenPresent(fetchFirstRows);
        }

        FetchFirstFinisher<T> fetchFirstWhenPresent(Long fetchFirstRows);
    }

    @FunctionalInterface
    interface FetchFirstFinisher<T> {
        Buildable<T> rowsOnly();
    }
}