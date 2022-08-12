package io.adabox.model.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RawResponse {

    private String type;
    private String version;
    private String servicename;
    private String methodname;
    private JsonNode fault;
    private JsonNode result;
    private JsonNode reflection;
}
