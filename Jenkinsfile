@Library('cloudops')
import com.bose.cloudops.*

def cloudops = new CloudOps(this)
cloudops.slackChannelName = "#eco2-data-reconciliation-b"

node {
  // Process and execute the galapagos.yaml flow
  cloudops.executeMatrixBasedFlow()
}