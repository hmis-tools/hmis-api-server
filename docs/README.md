Please describe here any documents that are not self-explanatory.

* `mirrorsync-compass-to-openhmis2-table-mappings.ods`
  These migration notes from Brian Vogler document the mappings that
  MirrorSync uses between Pathways COMPASS/ROSE tables, implemented in
  Oracle, and OpenHMIS2 tables, implemented in Google Cloud SQL.

* `HMIS-API-001-HUD-matchup.docx`
  A matchup of the Schema field names from HMIS API-0.0.1 with the HUD
  HMIS Data Standards.  Dave Totten posted this to the list on
  2015-07-19, as "HMIS API 001.docx", saying:

  [This
  mulesoft](https://anypoint.mulesoft.com/apiplatform/hmis-api/#/portals/organizations/1d2d1eb1-46af-4ee8-aa04-bd79ed2764a3/apis/7105/versions/7150#clients_client_id_enrollments_enroll_id_disabilities)
  shows a Schema button that shows the actual fieldnames in HTML
  format.  I copied and pasted these under the data standard number.
  I found most of the Universal Data Elements and could probably find
  the remaining data elements with enough time if that is useful but
  I'm assuming this has already been done.

* `legacy-schema/`
  The subset of the Pathways COMPASS/ROSE schema originally provided
  to use with OpenHMIS.  *Note this is not the schema we're using.*
  The real schema is reflected in migration files in this repository.
  The legacy schema provided here is for historical interest only.
  For example, its codes are not the same codes the real API uses.
