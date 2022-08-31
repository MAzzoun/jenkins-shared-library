import com.pwc.dfy.services.* 
   
def call(Map parameters = [:]) {
   def utilities = new Utilities()      
            try {
                utilities.firstMethode(nom: "$nom")
            } catch (err) {
                currentBuild.result = 'FAILED'
                throw err
            }
}
