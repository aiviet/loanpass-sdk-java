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

package com.youland.vendor.loanpass.model.product;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youland.vendor.loanpass.model.AnyOfProductSummaryStatus;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NonNull;

@Data
public class ProductSummaryStatusAsAvailable extends AnyOfProductSummaryStatus {
    public static final String FIELD_NAME_REQUIREDFIELDIDS = "requiredFieldIds";

    private List<String> requiredFieldIds;

    public ProductSummaryStatusAsAvailable() { super(ProductSummaryStatusOpt.AVAILABLE); }

    public ProductSummaryStatusAsAvailable fromJson(@NonNull JsonNode node)  {
        JsonNode jsonNodeArray = node.get(FIELD_NAME_REQUIREDFIELDIDS);
        ObjectMapper mapper = new ObjectMapper();
        requiredFieldIds = mapper.convertValue(jsonNodeArray, new TypeReference<>() {});
        return this;
    }
}
