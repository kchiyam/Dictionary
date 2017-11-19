package com.example.khanhchivu.myapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cleveroad.audiovisualization.AudioVisualization;
import com.cleveroad.audiovisualization.DbmHandler;
import com.cleveroad.audiovisualization.SpeechRecognizerDbmHandler;

import java.util.ArrayList;


public class SpeechRecognitionFragment extends Fragment {
    public static SpeechRecognitionFragment newInstance() {
        return new SpeechRecognitionFragment();
    }

    private AudioVisualization audioVisualization;
    private ImageButton btnRecognize;
    private SpeechRecognizerDbmHandler handler;
    private boolean recognizing;
    private TextView tvResult;
    private TextView tvStatus;

    private static final String TAP_TO_TRASNLATE = "TAP TO TRANSLATE";
    private static final String LISTENING = "LISTENING";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_speech_recognition, container, false);
        audioVisualization = (AudioVisualization) view.findViewById(R.id.visualizer_view);
        btnRecognize = (ImageButton) view.findViewById(R.id.btn_recognize);
        tvResult = (TextView) view.findViewById(R.id.tv_result);
        tvStatus = (TextView) view.findViewById(R.id.tv_status);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnRecognize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recognizing) {
                    handler.stopListening();
                } else {
                    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getContext().getPackageName());
                    handler.startListening(intent);
                }
                btnRecognize.setEnabled(false);
            }
        });
        handler = DbmHandler.Factory.newSpeechRecognizerHandler(getContext());
        handler.innerRecognitionListener(new SimpleRecognitionListener() {

            @Override
            public void onReadyForSpeech(Bundle params) {
                super.onReadyForSpeech(params);
                onStartRecognizing();
            }

            @Override
            public void onResults(Bundle results) {
                super.onResults(results);

                // tu them code
                ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                String text = "";
                text += matches.get(0);
                text += "\n or you mean: \n";
                for (int i = 1; i < matches.size(); i++) {
                    text += matches.get(i) + "\n";
                }
                tvResult.setText(text);

                onStopRecognizing();
            }

            @Override
            public void onError(int error) {
                super.onError(error);
                onStopRecognizing();

            }
        });
        audioVisualization.linkTo(handler);
    }

    private void onStopRecognizing() {
        recognizing = false;
        tvStatus.setText(TAP_TO_TRASNLATE);
        btnRecognize.setImageResource(R.drawable.ic_microphone);
        btnRecognize.setEnabled(true);
    }

    private void onStartRecognizing() {
        tvStatus.setText(LISTENING);
        btnRecognize.setImageResource(R.drawable.ic_microphone_started);
        btnRecognize.setEnabled(true);
        recognizing = true;
    }

    @Override
    public void onDestroyView() {
        audioVisualization.release();
        super.onDestroyView();
    }

    private static class SimpleRecognitionListener implements RecognitionListener {

        @Override
        public void onReadyForSpeech(Bundle params) {
        }

        @Override
        public void onBeginningOfSpeech() {
        }

        @Override
        public void onRmsChanged(float rmsdB) {
        }

        @Override
        public void onBufferReceived(byte[] buffer) {
        }

        @Override
        public void onEndOfSpeech() {
        }

        @Override
        public void onError(int error) {
        }

        @Override
        public void onResults(Bundle results) {
        }

        @Override
        public void onPartialResults(Bundle partialResults) {
        }

        @Override
        public void onEvent(int eventType, Bundle params) {
        }
    }
}
