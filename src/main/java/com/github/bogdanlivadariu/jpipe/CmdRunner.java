package com.github.bogdanlivadariu.jpipe;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.List;

class CmdRunner {
    static InputStream singleRun(String command) throws IOException {
        return Runtime.getRuntime().exec(command).getInputStream();
    }

    static InputStream multiRun(List<String> commands) throws IOException {
        ArrayDeque<String> d = new ArrayDeque<>(commands);

        Process p = Runtime.getRuntime().exec(d.pop());

        return internalRun(d, p.getInputStream());
    }

    private static InputStream internalRun(ArrayDeque<String> commands, InputStream upstreamInputStream) throws IOException {
        String cmd = commands.pop();

        Process p = Runtime.getRuntime().exec(cmd);

        InputStream is = p.getInputStream();
        try (OutputStream os = p.getOutputStream()) {
            IOUtils.copy(upstreamInputStream, os);
        }
        upstreamInputStream.close();

        if (commands.isEmpty()) {

            return is;
        }

        return internalRun(commands, is);
    }
}
