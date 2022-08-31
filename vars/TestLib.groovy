/**
 * Classic Maven build
 * @param no parameter
 * @return
 */
def call(Map parameters = [:]) {
   
            try {
                 bat 'echo ça marche'
            } catch (err) {
                currentBuild.result = 'FAILED'
                throw err
            }
}
