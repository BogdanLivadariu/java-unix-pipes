package com.github.bogdanlivadariu.jpipe;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PipeRuntime {

    public static String exec(String command) throws IOException {
        List<String> commands = CmdHelper.splitByPipe(command);

        if (commands.size() > 1) {
            InputStream is = CmdRunner.multiRun(commands);

            return CmdHelper.getString(is);
        }

        InputStream is = CmdRunner.singleRun(commands.get(0));

        return CmdHelper.getString(is);
    }
}
