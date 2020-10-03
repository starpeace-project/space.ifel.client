package client.configuration;

import client.utilities.ClassUtils;
import client.utilities.FileUtils;
import client.utilities.StringUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ConfigManager {
    private final String configPath;
    private final ArrayList<Object> configFiles = new ArrayList<>();
    private final static Map<String, ClientConfig> configs = new HashMap<>();

    public ConfigManager(String configPath) throws Exception {
        this.configPath = configPath;

        try (Stream<Path> paths = Files.walk(Paths.get(configPath))) {
            for (Object path : paths.toArray()) {
                if (path.toString().endsWith(".json")) {
                    configFiles.add(path);
                }
            }
        }

        for (Object path : configFiles) {
            File file = new File(path.toString());
            String configString = Files.readString(Path.of(file.getPath()));

            String className = StringUtils.toCamelCase(FileUtils.getBaseName(path.toString()), "_");

            if (ClassUtils.isClass("client.configuration", className)) {
                configs.put(FileUtils.getBaseName(path.toString()), ConfigFactory.load(configString, "client.configuration." + className));
            } else {
                System.out.println("NO CLASS FOUND FOR " + className);
            }
        }

        System.out.println("Registering config manager shutdown hook.");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down writing configs to disk.");
            for (Object path : configFiles) {
                File file = new File(path.toString());
                ConfigFactory.save(file, configs.get(FileUtils.getBaseName(path.toString())));
            }
        }));
    }

    public static ClientConfig get(String configClass) {
        if (configs.containsKey(configClass)) {
            return configs.get(configClass);
        }

        return null;
    }
}
