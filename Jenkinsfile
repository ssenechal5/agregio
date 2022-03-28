#!/usr/bin/env groovy

@Library('shared-jenkins-library') _

// for all parameters, see example: https://git.int.../shared-jenkins-library/blob/master/Jenkinsfile

mavenPipeline {

    // the node name
    // [OPTIONAL, default: null]
    node = 'dind-build'

    // the main branch of the project (master, develop)
    // [MANDATORY]
    mainBranch = 'default'

    // if true, post release a merge is performed into master branch (from mainBranch)
    // [MANDATORY]
    mergeToMaster = false

    // java tool (jdk7, jdk8)
    // [MANDATORY]
    javaTool = 'jdk17'

    // the project name used in email notifications
    // [MANDATORY]
    projectName = 'agregio'

    // the profiles launched in build stages (Build, Test, Quality Scan)
    // [OPTIONAL, default: None]
    buildProfiles = ['prod']

    // the profiles launched in package stages (Deploy, Release)
    // [OPTIONAL, default: None]
    packageProfiles = ['prod']


    // the artifacts to deploy (Deploy, Release)
    // the artifact block uses the standard artifactory parameter (see https://www.jfrog.com/confluence/display/RTF/Using+File+Specs)
    // in target field, the pattern '(version)' is automatically replaced by the current version
    // in target field, the pattern '(versionTemporal)' is automatically replaced by the current temporal version
    // Temporal version => release format: 1.2.3 -> 1.2.3, snapshot format: 1.2.3-SNAPSHOT -> 1.2.3-20170830.171438-109 (release version + date + build number)
    // [OPTIONAL, default: None]
    deployArtifacts = [
    ]

    // the SNAPSHOT artifacts to delete post release
    removeArtifacts = [
    ]

    // the attached files of the release email
    // [OPTIONAL, default: None]
    attachmentsPaths = ['ChangeLog.txt']

    // the artifact names used to build artifactory links of the release email
    // [OPTIONAL, default: None]
    artifactsLinks = [
    ]

    // Property that enables the wait until a person validates the sending of the release email on Jenkins job (only in release mode)
    // if true, the release step will be surrounded by dotted lines and on mouse over, a popup will be displayed to resume or abord the job
    // beware of the global timeout (90 minutes by default), if the timeout is reached, the job will fail and the email will not be sent
    // [OPTIONAL, default: false]
    waitValidationBeforeSendingMail = true
}
