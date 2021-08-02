// Copyright 2021 YouLand Inc. (youland.com)
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.youland.vendor.loanpass.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.youland.vendor.loanpass.model.product.ProductExecutionStatusOpt;
import com.youland.vendor.loanpass.serializer.AnyOfProductExecutionStatusDeserializer;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

@Data
@JsonDeserialize(using = AnyOfProductExecutionStatusDeserializer.class)
public class AnyOfProductExecutionStatus {
    public static final String FIELD_NAME_TYPE = "type";

    @Setter(AccessLevel.NONE)
    private ProductExecutionStatusOpt type;

    @SuppressWarnings("unused")
    protected AnyOfProductExecutionStatus() { }
    protected AnyOfProductExecutionStatus(ProductExecutionStatusOpt type) { this.type = type; }

    public static ProductExecutionStatusOpt getTypeFromJson(@NonNull JsonNode node)  {
        String typeAsSt = node.get(FIELD_NAME_TYPE).asText();
        ProductExecutionStatusOpt type = ProductExecutionStatusOpt.VALUE2ENUM.get(typeAsSt);
        assert type != null : String.format("Invalid enum value: '%s'", typeAsSt);
        return type;
    }
}
