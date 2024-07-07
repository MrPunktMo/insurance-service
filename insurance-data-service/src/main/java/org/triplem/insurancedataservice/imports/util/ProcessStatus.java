package org.triplem.insurancedataservice.imports.util;

public enum ProcessStatus {
    STARTED("Importvorgang gestartet."),
	RUNNING("Importvorgang bereits gestartet (beschäftigt)."),
    FINISHED("Importvorgang abgeschlossen."),
    FAILED("Importvorgang fehlgeschlagen.");

    String statusMessage;

    ProcessStatus(String statusMessage) {
        this.statusMessage = statusMessage;
    }

}
