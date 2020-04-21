# SqlParser-Android

## Overview

A framework used to parser a Sql script file or mass string long Sql script to a statments array.

fully support protocol:
http://www.contrib.andrew.cmu.edu/~shadow/sql/sql1992.txt

The original purpose was fixed a bug in `WatermelonDB`(https://github.com/Nozbe/WatermelonDB) when it try to parser a mass sql script string got crash if it contian a grammar such as `create trigger` with double ';', so I created this lib to who also had same problem.
please feel free to commit issue:)


## Setup
#### Gradle
Step 1. Add it in your root build.gradle at the end of repositories:
```
allprojects {
  repositories {
    ...
    jcenter()
    // or
    maven { url 'https://jitpack.io' }
  }
}
```
Step 2. Add the dependency
```
dependencies {
  implementation 'com.github.xelven:SqlParser-Android:1.0'
}
```

#### Maven
Step 1. Add the JitPack repository to your build file
```
<repositories>
  <repository>
    <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>
```
Step 2. Add the dependency
```
<dependency>
  <groupId>com.github.xelven</groupId>
  <artifactId>SqlParser-Android</artifactId>
  <version>1.0</version>
</dependency>
```



## Sample Usage
```java
// give a mass sql script string
String script = "create table "ans" ("id" primary key, "_changed", "_status", "database_id", "question_id", "aaa_id", "answer");create index ans_database_id on "ans" ("database_id");create index ans_question_id on "ans" ("question_id");create index ans_aaa_id on "ans" ("aaa_id");create index ans__status on "ans" ("_status");create table "aaas" ("id" primary key, "_changed", "_status", "graph_ql_id", "database_id", "party_id", "first_name", "last_name", "name", "email", "secondary_email_addresses", "phone", "company", "job_position", "industry", "registration_number", "xtra_token", "custom_qrcode", "nature", "ee", "checked_in_at", "checked_in_with", "sss_ids", "group_ids", "provider_id", "updated_at", "custom_fields", "remarks", "salutation", "auto_id", "nb_id", "country", "city", "ans", "custom_lines", "sss_attendances", "status", "is_dirty", "cursor", "searchable_keywords", "searchable_ggg", "searchable_objects");create index aaas_database_id on "aaas" ("database_id");create index aaas_party_id on "aaas" ("party_id");create index aaas_name on "aaas" ("name");create index aaas_xtra_token on "aaas" ("xtra_token");create index aaas_custom_qrcode on "aaas" ("custom_qrcode");create index aaas_nature on "aaas" ("nature");create index aaas_ee on "aaas" ("ee");create index aaas_checked_in_with on "aaas" ("checked_in_with");create index aaas_is_dirty on "aaas" ("is_dirty");create index aaas__status on "aaas" ("_status");create virtual table "aaas_fts" using fts4("searchable_keywords", "searchable_ggg", "searchable_objects");create trigger "aaas_fts_delete" after delete on "aaas" begin delete from "aaas_fts" where "rowid" = OLD.rowid; end;create trigger "aaas_fts_insert" after insert on "aaas" begin insert into "aaas_fts" ("rowid", "searchable_keywords", "searchable_ggg", "searchable_objects") values (NEW."rowid", NEW."searchable_keywords", NEW."searchable_ggg", NEW."searchable_objects”); end;create trigger "aaas_fts_update" after update on "aaas" begin update "aaas_fts" set "searchable_keywords" = NEW."searchable_keywords", "searchable_ggg" = NEW."searchable_ggg", "searchable_objects" = NEW."searchable_objects" where "rowid" = NEW."rowid”; end;create table "ggg" ("id" primary key, "_changed", "_status", "database_id", "ggp_id", "name", "short_code", "ggp_and_group_name");create index ggg_database_id on "ggg" ("database_id");create index ggg_ggp_id on "ggg" ("ggp_id");create index ggg__status on "ggg" ("_status");create table "ggps" ("id" primary key, "_changed", "_status", "database_id", "party_id", "name", "kind", "group_ids");create index ggps_database_id on "ggps" ("database_id");create index ggps_party_id on "ggps" ("party_id");create index ggps__status on "ggps" ("_status");create table "nbs" ("id" primary key, "_changed", "_status", "database_id", "party_id", "name", "design", "svg_template");create index nbs_database_id on "nbs" ("database_id");create index nbs_party_id on "nbs" ("party_id");create index nbs__status on "nbs" ("_status");create table "ppp" ("id" primary key, "_changed", "_status", "graphql_id", "database_id", "name", "start_at", "end_at", "place", "details", "logo", "logo_bnw", "aaa_ids", "ggp_ids", "updated_at", "created_at", "custom_aaa_field_names", "walk_in_config", "updated_aaa_ids", "questions", "namecard_quota", "aaa_index", "aaa_count", "is_completely_downloaded", "cursor");create index ppp_database_id on "ppp" ("database_id");create index ppp_name on "ppp" ("name");create index ppp__status on "ppp" ("_status");";
SQLParser p = new SQLParser();
p.setUseScriptDetecting(true);
p.parseScript(script);
List<SQLStatement> stats = p.getStatements();
for (SQLStatement s : stats) {
	System.out.println("*****************");
	System.out.println(s.getSQL());
}
```


## Developed By

* Allen Chan 
 
&nbsp;&nbsp;&nbsp;**Email** - xelven@gmail.com





## License

```
Copyright 2020 Allen Chan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
