import Button from './components/button';

export default function ImportExport() {
  return (
    <div className="align">
      <h2>Import and Export Component</h2>
      <p>This component demonstrates import and export functionality in React.</p>
      <br />
      <Button /> <span>--- This button is imported from another file.</span>
    </div>
  );
}