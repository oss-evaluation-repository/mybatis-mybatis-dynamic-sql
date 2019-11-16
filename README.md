# MyBatis Dynamic SQL

[![Build Status](https://travis-ci.org/mybatis/mybatis-dynamic-sql.svg?branch=master)](https://travis-ci.org/mybatis/mybatis-dynamic-sql)
[![Coverage Status](https://coveralls.io/repos/github/mybatis/mybatis-dynamic-sql/badge.svg?branch=master)](https://coveralls.io/github/mybatis/mybatis-dynamic-sql?branch=master)
[![Maven central](https://maven-badges.herokuapp.com/maven-central/org.mybatis.dynamic-sql/mybatis-dynamic-sql/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.mybatis.dynamic-sql/mybatis-dynamic-sql)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/https/oss.sonatype.org/org.mybatis.dynamic-sql/mybatis-dynamic-sql.svg)](https://oss.sonatype.org/content/repositories/snapshots/org/mybatis/dynamic-sql/mybatis-dynamic-sql/)
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=mybatis_mybatis-dynamic-sql&metric=alert_status)](https://sonarcloud.io/dashboard?id=mybatis_mybatis-dynamic-sql)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=mybatis_mybatis-dynamic-sql&metric=security_rating)](https://sonarcloud.io/dashboard?id=mybatis_mybatis-dynamic-sql)

## What Is This?
This library is a framework for generating dynamic SQL statements.  Think of it as a typesafe SQL templating library,
with additional support for MyBatis3 and Spring JDBC Templates.

The library will generate full DELETE, INSERT, SELECT, and UPDATE statements formatted for use by MyBatis or Spring.
The most common use case is to generate statements, and a matching set of parameters, that can be directly used
by MyBatis.  The library will also generate statements and parameter objects that are compatible with Spring JDBC
templates.

The library works by implementing an SQL-like DSL that creates an object containing a full SQL statement and any
parameters required for that statement.  The SQL statement object can be used directly by MyBatis as a parameter to a mapper method.

The library also contains extensions for Kotlin that enable an idiomatic Kotlin DSL.

See the following pages for further information:

| Page | Comments|
|------|---------|
|[Quick Start](src/site/markdown/docs/quickStart.md) | Shows a complete example of building code for this library |
|[MyBatis3 Support](src/site/markdown/docs/mybatis3.md) | Information about specialized support for [MyBatis3](https://github.com/mybatis/mybatis-3). The examples on this page are similar to the code generated by [MyBatis Generator](https://github.com/mybatis/generator) |
|[Kotlin Support with MyBatis3](src/site/markdown/docs/kotlinMyBatis3.md) | Information about the Kotlin extensions and Kotlin DSL when using MyBatis3 as the runtime |
|[Spring Support](src/site/markdown/docs/spring.md) | Information about specialized support for Spring JDBC Templates |
|[Kotlin Support with Spring](src/site/markdown/docs/kotlinSpring.md) | Information about the Kotlin extensions and Kotlin DSL when using Spring JDBC Template as the runtime |
|[Spring Batch Support](src/site/markdown/docs/springBatch.md) | Information about specialized support for Spring Batch using the [MyBatis Spring Integration](https://github.com/mybatis/spring) |

## Requirements

The library has no dependencies.  Java 8 or higher is required.
