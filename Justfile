set shell := ["bash", "-u", "-o", "pipefail", "-c"]

# Beide Projekte testen und am Ende eine direkte Übersicht anzeigen.
test-compare:
    @status4=0; \
    status5=0; \
    echo "====================================================="; \
    echo "Running tests for Micronaut 4.10.18"; \
    echo "====================================================="; \
    cd micronaut-4-10-18 && ./gradlew test || status4=$?; \
    cd ..; \
    echo ""; \
    echo "====================================================="; \
    echo "Running tests for Micronaut 5.2.4"; \
    echo "====================================================="; \
    cd micronaut-5-2-4 && ./gradlew test || status5=$?; \
    cd ..; \
    echo ""; \
    echo "================ TEST RESULT SUMMARY ================"; \
    if [ "$status4" -eq 0 ]; then \
      result4="PASS"; \
    else \
      result4="FAIL"; \
    fi; \
    if [ "$status5" -eq 0 ]; then \
      result5="PASS"; \
    else \
      result5="FAIL"; \
    fi; \
    printf "%-18s : %s\n" "Micronaut 4.10.18" "$result4"; \
    printf "%-18s : %s\n" "Micronaut 5.2.4" "$result5"; \
    echo "====================================================="; \
    echo ""; \
    echo "Reports:"; \
    echo "Micronaut 4.10.18: micronaut-4-10-18/build/reports/tests/test/index.html"; \
    echo "Micronaut 5.2.4  : micronaut-5-2-4/build/reports/tests/test/index.html"; \
    echo ""; \
    if [ "$status4" -ne 0 ] || [ "$status5" -ne 0 ]; then \
      exit 1; \
    fi

# Dasselbe, aber mit clean vorher.
clean-test-compare:
    @status4=0; \
    status5=0; \
    echo "====================================================="; \
    echo "Running clean tests for Micronaut 4.10.18"; \
    echo "====================================================="; \
    cd micronaut-4-10-18 && ./gradlew clean test || status4=$?; \
    cd ..; \
    echo ""; \
    echo "====================================================="; \
    echo "Running clean tests for Micronaut 5.2.4"; \
    echo "====================================================="; \
    cd micronaut-5-2-4 && ./gradlew clean test || status5=$?; \
    cd ..; \
    echo ""; \
    echo "================ TEST RESULT SUMMARY ================"; \
    if [ "$status4" -eq 0 ]; then \
      result4="PASS"; \
    else \
      result4="FAIL"; \
    fi; \
    if [ "$status5" -eq 0 ]; then \
      result5="PASS"; \
    else \
      result5="FAIL"; \
    fi; \
    printf "%-18s : %s\n" "Micronaut 4.10.18" "$result4"; \
    printf "%-18s : %s\n" "Micronaut 5.2.4" "$result5"; \
    echo "====================================================="; \
    echo ""; \
    echo "Reports:"; \
    echo "Micronaut 4.10.18: micronaut-4-10-18/build/reports/tests/test/index.html"; \
    echo "Micronaut 5.2.4  : micronaut-5-2-4/build/reports/tests/test/index.html"; \
    echo ""; \
    if [ "$status4" -ne 0 ] || [ "$status5" -ne 0 ]; then \
      exit 1; \
    fi