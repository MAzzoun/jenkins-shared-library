/**
 * Classic Maven build
 * @param no parameter
 * @return
 */
def call(Map parameters = [:]) {
   
   
            try {
                 firstMethode(nom: "$nom")
            } catch (err) {
                currentBuild.result = 'FAILED'
                throw err
            }
}
