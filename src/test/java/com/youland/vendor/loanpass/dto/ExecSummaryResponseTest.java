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

package com.youland.vendor.loanpass.dto;

import com.youland.lib.core.JsonUtil;
import com.youland.vendor.loanpass.model.ExecutionProductSummary;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExecSummaryResponseTest {
    private static final String FOLDER_TEST ="./src/test/testdata/execsummary/";
    private static final Object[] _testData = {
            FOLDER_TEST + "response_others.json"
    };

    @BeforeAll
    public static void setupClass() {
        System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());
        Assertions.assertTrue(Files.isDirectory(Paths.get(FOLDER_TEST)));
    }

    @AfterAll
    public static void tearDownClass() { }

    @Test
    void test_deserialize_available() throws IOException {
        //Arrange
        //Action
        ExecSummaryResponse obj
                = JsonUtil.file2Obj(FOLDER_TEST + "response_available.json", ExecSummaryResponse.class);

        //Assert
        Assertions.assertNotNull(obj);
        System.out.println(obj);
    }

    @Test
    void test_deserialize_approved() throws IOException {
        //Arrange
        //Action
        ExecSummaryResponse obj
                = JsonUtil.file2Obj(FOLDER_TEST + "response_approved.json", ExecSummaryResponse.class);

        //Assert
        Assertions.assertNotNull(obj);
        System.out.println(obj);
    }

    @SuppressWarnings("unused")
    private static Object[] provideTestData() {
        return _testData;
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test_deserialize(String filename) throws IOException {
        //Arrange
        //Action
        ExecSummaryResponse obj
                = JsonUtil.file2Obj(filename, ExecSummaryResponse.class);

        //Assert
        Assertions.assertNotNull(obj);
        System.out.println(JsonUtil.stringify(obj));
    }
}