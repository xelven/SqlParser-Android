package org.xelven.testsqlparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import org.xelven.sqlparser.SQLParser;
import org.xelven.sqlparser.SQLStatement;

import java.util.List;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println("################# testTriggerLineParserIssue");
		String script = "create table \"answers\" (\"id\" primary key, \"_changed\", \"_status\", \"database_id\", \"question_id\", \"attendee_id\", \"answer\");create index answers_database_id on \"answers\" (\"database_id\");create index answers_question_id on \"answers\" (\"question_id\");create index answers_attendee_id on \"answers\" (\"attendee_id\");create index answers__status on \"answers\" (\"_status\");create table \"attendees\" (\"id\" primary key, \"_changed\", \"_status\", \"graph_ql_id\", \"database_id\", \"party_id\", \"first_name\", \"last_name\", \"name\", \"email\", \"secondary_email_addresses\", \"phone\", \"company\", \"job_position\", \"industry\", \"registration_number\", \"xtra_token\", \"custom_qrcode\", \"nature\", \"attended\", \"checked_in_at\", \"checked_in_with\", \"session_ids\", \"group_ids\", \"provider_id\", \"updated_at\", \"custom_fields\", \"remarks\", \"salutation\", \"auto_id\", \"name_badge_id\", \"country\", \"city\", \"answers\", \"custom_lines\", \"session_attendances\", \"status\", \"is_dirty\", \"cursor\", \"searchable_keywords\", \"searchable_groups\", \"searchable_objects\");create index attendees_database_id on \"attendees\" (\"database_id\");create index attendees_party_id on \"attendees\" (\"party_id\");create index attendees_name on \"attendees\" (\"name\");create index attendees_xtra_token on \"attendees\" (\"xtra_token\");create index attendees_custom_qrcode on \"attendees\" (\"custom_qrcode\");create index attendees_nature on \"attendees\" (\"nature\");create index attendees_attended on \"attendees\" (\"attended\");create index attendees_checked_in_with on \"attendees\" (\"checked_in_with\");create index attendees_is_dirty on \"attendees\" (\"is_dirty\");create index attendees__status on \"attendees\" (\"_status\");create virtual table \"attendees_fts\" using fts4(\"searchable_keywords\", \"searchable_groups\", \"searchable_objects\");create trigger \"attendees_fts_delete\" after delete on \"attendees\" begin delete from \"attendees_fts\" where \"rowid\" = OLD.rowid; end;create trigger \"attendees_fts_insert\" after insert on \"attendees\" begin insert into \"attendees_fts\" (\"rowid\", \"searchable_keywords\", \"searchable_groups\", \"searchable_objects\") values (NEW.\"rowid\", NEW.\"searchable_keywords\", NEW.\"searchable_groups\", NEW.\"searchable_objects”); end;create trigger \"attendees_fts_update\" after update on \"attendees\" begin update \"attendees_fts\" set \"searchable_keywords\" = NEW.\"searchable_keywords\", \"searchable_groups\" = NEW.\"searchable_groups\", \"searchable_objects\" = NEW.\"searchable_objects\" where \"rowid\" = NEW.\"rowid”; end;create table \"groups\" (\"id\" primary key, \"_changed\", \"_status\", \"database_id\", \"grouping_id\", \"name\", \"short_code\", \"grouping_and_group_name\");create index groups_database_id on \"groups\" (\"database_id\");create index groups_grouping_id on \"groups\" (\"grouping_id\");create index groups__status on \"groups\" (\"_status\");create table \"groupings\" (\"id\" primary key, \"_changed\", \"_status\", \"database_id\", \"party_id\", \"name\", \"kind\", \"group_ids\");create index groupings_database_id on \"groupings\" (\"database_id\");create index groupings_party_id on \"groupings\" (\"party_id\");create index groupings__status on \"groupings\" (\"_status\");create table \"name_badges\" (\"id\" primary key, \"_changed\", \"_status\", \"database_id\", \"party_id\", \"name\", \"design\", \"svg_template\");create index name_badges_database_id on \"name_badges\" (\"database_id\");create index name_badges_party_id on \"name_badges\" (\"party_id\");create index name_badges__status on \"name_badges\" (\"_status\");create table \"parties\" (\"id\" primary key, \"_changed\", \"_status\", \"graphql_id\", \"database_id\", \"name\", \"start_at\", \"end_at\", \"place\", \"details\", \"logo\", \"logo_bnw\", \"attendee_ids\", \"grouping_ids\", \"updated_at\", \"created_at\", \"custom_attendee_field_names\", \"walk_in_config\", \"updated_attendee_ids\", \"questions\", \"namecard_quota\", \"attendee_index\", \"attendee_count\", \"is_completely_downloaded\", \"cursor\");create index parties_database_id on \"parties\" (\"database_id\");create index parties_name on \"parties\" (\"name\");create index parties__status on \"parties\" (\"_status\");";
		SQLParser p = new SQLParser();
		p.setUseScriptDetecting(true);
		p.parseScript(script);
		List<SQLStatement> stats = p.getStatements();
		for (SQLStatement s : stats) {
			System.out.println("*****************");
			System.out.println(s.getSQL());
		}
	}
}
