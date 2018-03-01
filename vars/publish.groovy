def checkstyleReport(String checkstyleMainPath = 'build/reports/checkstyle/main.xml', String checkstyleTestPath = 'build/reports/checkstyle/test.xml') {
	if (fileExists(checkstyleMainPath)) {
        checkstyle pattern: "${checkstyleMainPath}"
    }

	if (fileExists(checkstyleTestPath)) {
        checkstyle pattern: "${checkstyleTestPath}"
    }
}

def findbugsReport(String findBugsMainPath = 'build/reports/findbugs/main.xml', String findBugsTestPath = 'build/reports/findbugs/test.xml') {
    if (fileExists(findBugsMainPath)) {
        findbugs pattern: "${findBugsMainPath}"
    }

	if (fileExists(findBugsTestPath)) {
        findbugs pattern: "${findBugsTestPath}"
    }
}

def pmdReport(String pmdMainPath = 'build/reports/pmd/main.xml', String pmdTestPath = 'build/reports/pmd/test.xml') {
    if (fileExists(pmdMainPath)) {
        pmd pattern: "${pmdMainPath}"
    }

	if (fileExists(pmdTestPath)) {
        pmd pattern: "${pmdTestPath}"
    }
}

def allureReport(String resultsPath = 'build/allure-results') {
    if (fileExists(resultsPath)) {
        allure jdk: 'JDK 8', results: [[path: "${resultsPath}"]]
    }
}
