package com.github.bogdanlivadariu.jpipe;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class CmdHelper {
    static List<String> splitByPipe(String command) {
        return Arrays.stream(command.split("\\|")).map(String::trim).collect(Collectors.toList());
    }

    static String getString(InputStream is) throws IOException {
        String data = IOUtils.toString(is, StandardCharsets.UTF_8);

        is.close();

        return data;
    }
}
