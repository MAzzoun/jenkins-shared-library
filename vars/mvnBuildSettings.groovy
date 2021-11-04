import com.pwc.dfy.services.DevOpsConf

/**
 * build project with settings.xml
 * @param parameters
 * @return
 */
def call(Map parameters = [:]) {

    def param = parameters.get('param')
    def mvn = tool(DevOpsConf.MAVEN_INSTALLATION)


    try {


                //settings.xml
                def filePath = DevOpsConf.ITOPS_SETTINGS_FILE
                def contentfile = libraryResource filePath
                def pathManifest = './home/jenkins/.m2/' + 'settings.xml'
                writeFile file: pathManifest, text: contentfile


        sh """
           ${mvn}/bin/mvn deploy:deploy-file \
          -DgroupId="com.file.nexus" \
          -DartifactId="jenkins" \
          -Dversion="1.0.${BUILD_NUMBER}" \
          -DgeneratePom=false \
          -DrepositoryId="maven-snapshots" \
          -Durl="http://172.17.0.3:8081/repository/maven-snapshots/" \
          -Dfile="myfile.zip" -s ${pathManifest}
      """


    } catch (err) {
        currentBuild.result = 'FAILED'
        throw err
    }
}