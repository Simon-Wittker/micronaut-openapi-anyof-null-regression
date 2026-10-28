package ch.finma.iir;

import static org.junit.jupiter.api.Assertions.assertTrue;

import ch.finma.iir.client.model.EntityReference;
import ch.finma.iir.client.model.InsuranceBrokerage;
import ch.finma.iir.client.model.InsuranceLine;
import ch.finma.iir.client.model.InsuranceLineCode;
import ch.finma.iir.client.model.LegalForm;
import ch.finma.iir.client.model.LegalFormCode;
import ch.finma.iir.client.model.LicenseType;
import ch.finma.iir.client.model.LicenseTypeCode;
import ch.finma.iir.client.model.SearchCategory;
import ch.finma.iir.client.model.SearchResult;
import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;

/**
 * Checks the code generated from ../iir-finma-api.json.
 * Properties declared as {@code anyOf: [{$ref: <Enum>}, {type: null}]} must be generated
 * with the referenced enum (or model) type.
 * Passes with Micronaut 4.10.18, fails with Micronaut 5.2.4.
 */
class GeneratedEnumsTest {

  @Test
  void searchResultCategoryReusesSearchCategoryEnum() throws Exception {
    assertEnumFieldType(SearchResult.class, "category", SearchCategory.class);
  }

  @Test
  void entityReferenceRelationTypeIsEnum() throws Exception {
    assertEnumField(EntityReference.class, "relationType");
  }

  @Test
  void searchResultReusesLegalFormModel() throws Exception {
    assertFieldType(SearchResult.class, "legalForm", LegalForm.class);
  }

  @Test
  void searchResultReusesLicenseTypeModel() throws Exception {
    assertFieldType(SearchResult.class, "licenseType", LicenseType.class);
  }

  @Test
  void insuranceBrokerageReusesLegalFormModel() throws Exception {
    assertFieldType(InsuranceBrokerage.class, "legalForm", LegalForm.class);
  }

  @Test
  void insuranceLineCodeReusesInsuranceLineCodeEnum() throws Exception {
    assertEnumFieldType(InsuranceLine.class, "code", InsuranceLineCode.class);
  }

  @Test
  void legalFormCodeReusesLegalFormCodeEnum() throws Exception {
    assertEnumFieldType(LegalForm.class, "code", LegalFormCode.class);
  }

  @Test
  void licenseTypeCodeReusesLicenseTypeCodeEnum() throws Exception {
    assertEnumFieldType(LicenseType.class, "code", LicenseTypeCode.class);
  }

  private static void assertEnumField(Class<?> owner, String fieldName) throws Exception {
    Class<?> type = field(owner, fieldName).getType();
    assertTrue(type.isEnum(),
      owner.getSimpleName() + "." + fieldName + " should be an enum but is " + type.getName());
  }

  private static void assertEnumFieldType(Class<?> owner, String fieldName, Class<?> expected) throws Exception {
    Class<?> type = field(owner, fieldName).getType();
    assertTrue(type == expected,
      owner.getSimpleName() + "." + fieldName + " should be of type " + expected.getSimpleName()
        + " but is " + type.getSimpleName());
    assertTrue(type.isEnum(),
      owner.getSimpleName() + "." + fieldName + " should be an enum but is " + type.getName());
  }

  private static void assertFieldType(Class<?> owner, String fieldName, Class<?> expected) throws Exception {
    Class<?> type = field(owner, fieldName).getType();
    assertTrue(type == expected,
      owner.getSimpleName() + "." + fieldName + " should be of type " + expected.getSimpleName()
        + " but is " + type.getSimpleName());
  }

  private static Field field(Class<?> owner, String name) throws NoSuchFieldException {
    return owner.getDeclaredField(name);
  }
}
