import * as React from 'react';

type Props = {
  data: ?string,
};

export default function Value(props: Props): React.MixedElement | null {
  const data = props.data;
  return (
    <div className="App">
        <p>{!data ? "Loading..." : data}</p>
    </div>
  );
}
